package shop.ecommerce.AddressService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressController{

    @Autowired 
    private AddressService AddressService;

    @PostMapping("/address")
    public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address) {
        Address address2 = AddressService.addAddress(address);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

}