
package com.proyectoap.guillermoalvarez.Repository;

import com.proyectoap.guillermoalvarez.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    
}
