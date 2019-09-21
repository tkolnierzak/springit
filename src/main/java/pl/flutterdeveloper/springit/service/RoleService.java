package pl.flutterdeveloper.springit.service;

import org.springframework.stereotype.Service;
import pl.flutterdeveloper.springit.domain.Role;
import pl.flutterdeveloper.springit.repository.RoleRepository;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }
}
