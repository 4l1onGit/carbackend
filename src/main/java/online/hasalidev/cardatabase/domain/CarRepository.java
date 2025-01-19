package online.hasalidev.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource()
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByBrand(@Param("brand") String brand);

    List<Car> findByColour(@Param("colour") String colour);

    List<Car> findByModelYear(@Param("modelYear") int modelYear);

    List<Car> findByModelYearAndBrand(@Param("modelYear") int modelYear, @Param("brand") String brand);

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(@Param("brand") String brand);

}
