package mapper;

import dto.UserDTO;
import entities.User;
import org.mapstruct.factory.Mappers;

public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract User fromDTO(UserDTO userDTO);
}
