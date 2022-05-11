package com.brainworks.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainworks.bindings.LoginForm;
import com.brainworks.bindings.RegistrationForm;
import com.brainworks.bindings.UnlockAccountForm;
import com.brainworks.entities.CityMasterEntity;
import com.brainworks.entities.CountryMasterEntity;
import com.brainworks.entities.StateMsterEntity;
import com.brainworks.entities.UserRegistrationEntity;
import com.brainworks.repository.CityMasterRepository;
import com.brainworks.repository.CountryMasterRepository;
import com.brainworks.repository.StateMasterRepository;
import com.brainworks.repository.UserRegistrationRepository;
import com.brainworks.utils.EmailUtils;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	@Autowired
	private EmailUtils emailUtil;
	@Autowired
	private UserRegistrationRepository userRegistrationRrpo;
	@Autowired
	private CityMasterRepository cityMasterRepo;
	@Autowired
	private StateMasterRepository stateMasterRepo;
	@Autowired
	private CountryMasterRepository countryMasterRepo;

	@Override
	public String login(LoginForm login) {
		UserRegistrationEntity entity = userRegistrationRrpo.findByEmailAndPassword(login.getEmail(),
				login.getPassword());
		if (entity == null) {
			return "INVALID CREDENTIALS";

		}
		if (entity != null && entity.getAccStatus().equals("LOCKED")) {
			return "USER ACCOUNT IS LOCKED";
		}
		return "LOGGED IN SUCCESSFUL";
	}

	@Override
	public Map<Integer, String> loadCountry() {
		List<CountryMasterEntity> countries = countryMasterRepo.findAll();
		Map<Integer, String> countryMap = new HashMap<>();
		for (CountryMasterEntity entity : countries) {
			countryMap.put(entity.getCountryId(), entity.getCountryName());

		}

		return countryMap;
	}

	@Override
	public Map<Integer, String> loadState(int countryid) {
		List<StateMsterEntity> statemaster = stateMasterRepo.findByCountryId(countryid);
		Map<Integer, String> entity = new HashMap();
		for (StateMsterEntity stateMasterMap : statemaster) {
			entity.put(stateMasterMap.getStateId(), stateMasterMap.getStateName());
		}

		return entity;
	}

	@Override
	public Map<Integer, String> loadCity(int stateid) {
		List<CityMasterEntity> cityMaster = cityMasterRepo.findByStateId(stateid);
		Map<Integer, String> cityMasterMap = new HashMap<Integer, String>();
		for (CityMasterEntity x : cityMaster) {
			cityMasterMap.put(x.getCityId(), x.getCityName());
		}

		return cityMasterMap;
	}

	@Override
	public String emailCheck(String email) {
		UserRegistrationEntity entity = userRegistrationRrpo.findByEmail(email);
		if (entity == null) {
			return "Email is unique";
		} else

			return "EMAIL IS ALREADY REGISTERED";
	}

	@Override
	public String saveAccount(RegistrationForm RegistrationForm) {
		UserRegistrationEntity userRegEntity = new UserRegistrationEntity();

		BeanUtils.copyProperties(RegistrationForm, userRegEntity);
		userRegEntity.setAccStatus("LOCKED");
		userRegEntity.setTempPassword(generateRandomPassword());
		UserRegistrationEntity savedEntity = userRegistrationRrpo.save(userRegEntity);

		String email = RegistrationForm.getEmail();
		String subject = "USER REGISTRATION - BRAINWORKS EXAM";
		String fileName = "UserAccount.txt";
		String body = readMailBodyContent(fileName, userRegEntity);
         emailUtil.sendEmail(email, subject, body);
	 	boolean isSent = emailUtil.sendEmail(email, subject, body);
		if (savedEntity.getUserId() != null && isSent) {
			return "success";
		}
		return "Failure";
	}

	@Override
	public String unlockacc(UnlockAccountForm unlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPass(String email) {

		UserRegistrationEntity entity = userRegistrationRrpo.findByEmail(email);
		if (entity == null) {
			return "INVALID EMAILID";

		}
		String fileName = "PasswordRecovery";
		String body = readMailBodyContent(fileName, entity);
		String subject = "Recover password";
		boolean isSent = emailUtil.sendEmail(email, subject, body);
		if (isSent) {
			return "Password sent to registered mail";
		}
		return "ERROR";

	}

	private String generateRandomPassword() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		return generatedString;
	}

	private String readMailBodyContent(String fileName, UserRegistrationEntity entity) {
		String mailBody = null;

		try {
			StringBuffer sb = new StringBuffer();

			FileReader fr = new FileReader(fileName); // read character by character
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine(); // reading first line data
			while (line != null) {
				sb.append(line); // appending line data to buffer object
				line = br.readLine(); // reading next line data

			}
			mailBody = sb.toString();
			
			mailBody = mailBody.replace("{FNAME}", entity.getFname());
			mailBody = mailBody.replace("{LNAME}", entity.getLname());
			mailBody = mailBody.replace("{TEMP-PWD}", entity.getTempPassword());
			mailBody = mailBody.replace("{EMAIL}", entity.getEmail());
			mailBody = mailBody.replace("{PWD}", entity.getPassword());
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mailBody;
	}
}