package online.hasalidev.cardatabase;

import online.hasalidev.cardatabase.domain.Owner;
import online.hasalidev.cardatabase.domain.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void saveOwner() {
        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");
        ownerRepository.save(owner);

        assertThat(
                ownerRepository.findByFirstName("John").isPresent()
        ).isTrue();
    }

    @Test
    void deleteOwner() {
       ownerRepository.save(new Owner("Lisa", "Morrison"));
       ownerRepository.deleteAll();

        assertThat(
                ownerRepository.count()
        ).isEqualTo(0);
    }
}
