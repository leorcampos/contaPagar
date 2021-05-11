package testePratico.ContaPagar.api.mapper;

public interface DomainMapper<E, DTO> {

	E toDomain(DTO dto);

	E updateDomain(E e, DTO dto);

	DTO fromDomain(E e);

}