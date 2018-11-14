package shop.ecommerce.AddressService;

import org.springframework.beans.factory.annotation.Autowired;

public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }
}