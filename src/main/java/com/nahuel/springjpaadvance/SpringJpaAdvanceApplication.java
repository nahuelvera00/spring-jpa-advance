package com.nahuel.springjpaadvance;

import com.nahuel.springjpaadvance.entities.Address;
import com.nahuel.springjpaadvance.entities.Client;
import com.nahuel.springjpaadvance.entities.Product;
import com.nahuel.springjpaadvance.entities.User;
import com.nahuel.springjpaadvance.repository.AddressRepository;
import com.nahuel.springjpaadvance.repository.ClientRepository;
import com.nahuel.springjpaadvance.repository.ProductRepository;
import com.nahuel.springjpaadvance.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class SpringJpaAdvanceApplication {
	private final ProductRepository productRepository;

	public SpringJpaAdvanceApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAdvanceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(
			UserRepository userRepository,
			ClientRepository clientRepository,
			AddressRepository addressRepository,
			ProductRepository productRepository
	){
		return args -> {
			User user1 = userRepository.save(new User(null,"Nahuel Vera", "1234"));
			User user2 = userRepository.save(new User(null,"Martin", "1234"));
			Client client1 = clientRepository.save(new Client(null, "Nahuel Client", user1, null, null));
			Client client2 = clientRepository.save(new Client(null, "client 2", user2, null, null));

			//Addresses
			Address address1 = addressRepository.save(new Address(null, "direccion 1", "numero 1", client1));
			Address address2 = addressRepository.save(new Address(null, "direccion 2", "numero 2", client1));
			Address address3 = addressRepository.save(new Address(null, "direccion 3", "numero 3", client2));
			client1.setAddresses(Set.of(address1, address2));
			client2.setAddresses(Set.of(address3));

			//Products

			Product p1 = productRepository.save(new Product(null, "Iphone 13", 144.99));
			Product p2 = productRepository.save(new Product(null, "Iphone 14", 190.99));
			Product p3 = productRepository.save(new Product(null, "Iphone 14 PRO", 249.99));

			client1.setProducts(Set.of(p1, p2, p3));
			client2.setProducts(Set.of(p1));

			Client clientUpdated = clientRepository.save(client1);
			Client clientUpdated2 = clientRepository.save(client2);



			System.out.println("Client name: " + clientUpdated.getName());
			System.out.println("User name: " + clientUpdated.getUser().getUsername());

			System.out.println("============================================");
			clientUpdated.getAddresses().forEach(a -> System.out.println("Address: "+ a.getStreet() + " "+ a.getNumber() ));
			System.out.println("============================================");
			clientUpdated.getProducts().forEach(p -> System.out.println("Product: "+ p.getName() + " - Value: "+ p.getPrice()));


			System.out.println(clientUpdated);
		};
	}

}
