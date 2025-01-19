package online.hasalidev.cardatabase;

import online.hasalidev.cardatabase.domain.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;


@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(
			CardatabaseApplication.class
	);

	public static void main(String[] args) {

		SpringApplication.run(CardatabaseApplication.class, args);


	}


	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;
	private final AppUserRepository userRepository;
	public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, AppUserRepository userRepository) {
		this.carRepository = carRepository;
		this.ownerRepository = ownerRepository;
		this.userRepository =  userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("John", "Smith");
		Owner owner2 = new Owner("Jane", "Doe");

		ownerRepository.saveAll(Arrays.asList(owner2, owner1));

		carRepository.save(new Car("Lexus", "LC500", "BLACK", "GFADS-DS", 2024, 7000, owner1));
		carRepository.save(new Car("Tesla", "Model 3", "BLACK", "GGHHD-D3D", 2023, 50000, owner2));

		for(Car car : carRepository.findAll()) {
			logger.info(car.toString());
		}

		userRepository.save(new AppUser("user", "$2y$10$KPPaayrTIfjrEq1TTbviTuq8BK32.UpBaUK0xD5EQQdYzaJrqL2K6", "USER"));
		userRepository.save(new AppUser("user2", "$2y$10$KPPaayrTIfjrEq1TTbviTuq8BK32.UpBaUK0xD5EQQdYzaJrqL2K6", "USER"));
		userRepository.save(new AppUser("admin", "$2y$10$KPPaayrTIfjrEq1TTbviTuq8BK32.UpBaUK0xD5EQQdYzaJrqL2K6", "ADMIN"));
	}

}
