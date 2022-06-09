package com.cars.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car>{

    @Query("select c from Car c order by c.price asc")
    List<Car> sortMin();

    @Query("select c from Car c order by c.price desc ")
    List<Car> findAllSortDesc();

    List<Car> findByTitleContaining(@Param("carTitle") String title);

    List<Car> findAllById(@Param("carId") Long id);

    @Query("select c from Car c where c.price > ?1")
    List<Car> findAllMinBoundPrice(int number);

    @Query("select c from Car c where c.price < ?1")
    List<Car> findAllMaxBoundPrice( int number);

    @Query("select c from Car c where c.price = ?1")
    List<Car> findAllEqualsPrice( int number);

    @Query("select c from Car c where c.price between ?1 and ?2")
    List<Car> findAllBetween( int numberMin, int numberMax);

    @Query("select c, sum(c.price) from Car c group by c.title")
    List<Car> findAllGroupBy();


    /*@Query("select p from Car p " +
            " where (p.title like concat('%', :title, '%') or :title is null) and" +
            "       (p.id = :id or :id is null) ")
    List<Car> findProductByFilter(@Param("id") Long id,
                                      @Param("title") String title);*/
    // List<Product> findProductByTitleLike();
}
