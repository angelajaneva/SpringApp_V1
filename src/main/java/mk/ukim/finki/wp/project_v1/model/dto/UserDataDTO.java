package mk.ukim.finki.wp.project_v1.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.wp.project_v1.model.Role;
import java.util.List;

@Getter
@Setter
public class UserDataDTO {

    @ApiModelProperty(position = 0)
    private String username;
    @ApiModelProperty(position = 1)
    private String email;
    @ApiModelProperty(position = 2)
    List<Role> roles;


}