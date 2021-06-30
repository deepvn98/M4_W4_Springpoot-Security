package com.example.demo.service.iplm;

import com.example.demo.model.AppRole;
import com.example.demo.model.AppUser;
import com.example.demo.repo.IAppUserRepository;
import com.example.demo.service.IAppUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private IAppUserRepository repository;

    @Override
    public Iterable<AppUser> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AppUser> getByID(Long id) {
        return repository.findById(id);
    }

    @Override
    public AppUser getByName(String name) {
        return repository.findAppUserByName(name);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return repository.save(appUser);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repository.findAppUserByName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(user.getRole());
        UserDetails userDetails = new User(user.getName(),user.getPassword(),authorities);
        return userDetails;
    }
}
