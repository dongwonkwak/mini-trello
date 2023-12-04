package dev.minitrello.configuration;

import dev.minitrello.adapters.output.h2.UserAccountAdapter;
import dev.minitrello.adapters.output.h2.mapper.UserAccountMapper;
import dev.minitrello.adapters.output.h2.repository.UserAccountRepository;
import dev.minitrello.application.ports.output.RegisterUserAccountStatePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceAdapterConfiguration {

    @Bean
    public RegisterUserAccountStatePort userAccountAdapter(
            UserAccountRepository userAccountRepository,
            UserAccountMapper mapper) {
        return new UserAccountAdapter(userAccountRepository, mapper);
    }

    @Bean
    public UserAccountMapper userAccountMapper() {
        return new UserAccountMapper();
    }
}
