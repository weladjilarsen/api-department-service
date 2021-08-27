package com.codewade.department.service;

import com.codewade.department.entity.Department;
import com.codewade.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public Department UpdateDepartment(Long departmentId, Department department) {
        log.info("Inside departmentId method of DepartmentService");
        if(departmentId > 0 && department != null){
            Department findDepartement = departmentRepository.findByDepartmentId(departmentId);
            if(findDepartement != null){
                findDepartement.setDepartmentCode(department.getDepartmentCode());
                findDepartement.setDepartmentAddress(department.getDepartmentAddress());
                findDepartement.setDepartmentName(department.getDepartmentName());

                return departmentRepository.save(findDepartement);
            }
        }
        return null;
    }
}
