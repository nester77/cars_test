package IG.test.repository;

import IG.test.entity.Car;
import IG.test.entity.CarPage;
import IG.test.entity.CarSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CarCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public CarCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Car> findAllWithFiltersForUser(CarPage carPage, CarSearchCriteria carSearchCriteria) {
        return findAllWithFilters(carPage, carSearchCriteria);
    }


    public Page<Car> findAllWithFilters(CarPage carPage,
                                        CarSearchCriteria carSearchCriteria) {
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> carRoot = criteriaQuery.from(Car.class);
        Predicate predicate = getPredicate(carSearchCriteria, carRoot);
        criteriaQuery.where(predicate);
        setOrder(carPage, criteriaQuery, carRoot);

        TypedQuery<Car> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(carPage.getPageNumber() * carPage.getPageSize());
        typedQuery.setMaxResults(carPage.getPageSize());

        Pageable pageable = getPageable(carPage);

        long carsCount = getCarsCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, carsCount);
    }

    private Predicate getPredicate(CarSearchCriteria carSearchCriteria,
                                   Root<Car> carRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(carSearchCriteria.getBrand())) {
            predicates.add(
                    criteriaBuilder.like(carRoot.get("brand"),
                            "%" + carSearchCriteria.getBrand() + "%")
            );
        }
        if (Objects.nonNull(carSearchCriteria.getModel())) {
            predicates.add(
                    criteriaBuilder.like(carRoot.get("model"),
                            "%" + carSearchCriteria.getModel() + "%")
            );
        }

        if (Objects.nonNull(carSearchCriteria.getYearOfIssueMin())) {
            predicates.add(
                    criteriaBuilder.ge((carRoot.get("yearOfIssue")),
                            carSearchCriteria.getYearOfIssueMin())
            );
        }

        if (Objects.nonNull(carSearchCriteria.getYearOfIssueMax())) {
            predicates.add(
                    criteriaBuilder.le((carRoot.get("yearOfIssue")),
                            carSearchCriteria.getYearOfIssueMax())
            );
        }

        if (Objects.nonNull(carSearchCriteria.getEngineCapacityMin())) {
            predicates.add(
                    criteriaBuilder.ge((carRoot.get("engineCapacity")),
                            carSearchCriteria.getEngineCapacityMin())
            );
        }

        if (Objects.nonNull(carSearchCriteria.getEngineCapacityMax())) {
            predicates.add(
                    criteriaBuilder.le((carRoot.get("engineCapacity")),
                            carSearchCriteria.getEngineCapacityMax())
            );
        }

        if (Objects.nonNull(carSearchCriteria.getMileageMax())) {
            predicates.add(
                    criteriaBuilder.le((carRoot.get("mileage")),
                            carSearchCriteria.getMileageMax())
            );
        }

        if (Objects.nonNull(carSearchCriteria.getPriceMin())) {
            predicates.add(
                    criteriaBuilder.ge((carRoot.get("price")),
                            carSearchCriteria.getPriceMin())
            );
        }

        if (Objects.nonNull(carSearchCriteria.getPriceMax())) {
            predicates.add(
                    criteriaBuilder.le((carRoot.get("price")),
                            carSearchCriteria.getPriceMax())
            );
        }

        if (Thread.currentThread().getStackTrace()[3].getMethodName()=="findAllWithFiltersForUser") {
            predicates.add(
                    criteriaBuilder.isFalse((carRoot.get("deletedCar")))
            );
        }


        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(CarPage employeePage,
                          CriteriaQuery<Car> criteriaQuery,
                          Root<Car> employeeRoot) {
        if (employeePage.getSortDirection().equals(Sort.Direction.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(employeeRoot.get(employeePage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(employeeRoot.get(employeePage.getSortBy())));
        }
    }

    private Pageable getPageable(CarPage employeePage) {
        Sort sort = Sort.by(employeePage.getSortDirection(), employeePage.getSortBy());
        return PageRequest.of(employeePage.getPageNumber(), employeePage.getPageSize(), sort);
    }

    private long getCarsCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Car> countRoot = countQuery.from(Car.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }



}
