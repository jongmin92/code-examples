package com.jongmin.springcore.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

public class BeanWrapperTest {

    @Test
    public void beanWrapperTest() {
        final Company obj = new Company();
        final BeanWrapper company = new BeanWrapperImpl(obj);

        final String name = "Some Company Inc.";
        company.setPropertyValue("name", name);
        assertThat(obj.getName()).isEqualTo(name);

        final String name2 = "Some Company2 Inc.";
        PropertyValue value = new PropertyValue("name", name2);
        company.setPropertyValue(value);
        assertThat(obj.getName()).isEqualTo(name2);
    }

    @Test
    public void nestedBeanWrapperTest() {
        final Company obj = new Company();
        final BeanWrapper company = new BeanWrapperImpl(obj);

        final BeanWrapper employee = new BeanWrapperImpl(new Employee());
        final String name = "jongmin";
        employee.setPropertyValue("name", name);

        company.setPropertyValue("employee", employee.getWrappedInstance());

        assertThat(obj.getEmployee()).isSameAs(employee.getWrappedInstance());
        assertThat(company.getPropertyValue("employee.name")).isEqualTo(name);
    }
}
