package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO dto);
    void updateAdmin(AdminDTO dto);
    AdminDTO searchAdmin(String id);
    String generateAdminIds();
    List<AdminDTO> getAllAdmin();
}
