package com.ayaz.assessment.domain;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RoleTest {

    @Test
    public void testRoleGettersAndSetters() {
        Role role = new Role();
        role.setDescription("Desc");
        role.setId(1L);
        role.setRoleName("Admin");

        assertNotNull(role.getDescription());
        assertNotNull(role.getId());
        assertNotNull(role.getRoleName());
    }
}
