package com.xhb.dc.kettle.portal.model.modelgrant.dto;

import java.util.List;
import lombok.Data;


/**
 * UserIdAndGroupIdAndGroupNamesDTO.
 */
@Data
public class UserIdAndGroupIdAndGroupNamesDTO {

    private String userId;

    private List<GroupIdAndGroupNamesDTO> list;

}
