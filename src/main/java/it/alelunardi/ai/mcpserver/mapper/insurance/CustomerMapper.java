package it.alelunardi.ai.mcpserver.mapper.insurance;

import it.alelunardi.ai.mcpserver.domain.insurance.CustomerDto;
import it.alelunardi.ai.mcpserver.repository.insurance.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);
}
