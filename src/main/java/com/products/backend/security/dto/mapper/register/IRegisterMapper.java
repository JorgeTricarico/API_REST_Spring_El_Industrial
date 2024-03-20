package com.products.backend.security.dto.mapper.register;

import com.products.backend.security.domain.entity.User;
import com.products.backend.security.dto.request.RegisterRequest;

public interface IRegisterMapper {
    User mapToUser(RegisterRequest request);
}
