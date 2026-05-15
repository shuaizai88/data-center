package com.xhb.dc.kettle.portal.model.custommodel.service.impl;

import com.xhb.dc.kettle.portal.model.custommodel.service.CustomModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>****************************************************************************</p>
 * <ul style="margin:15px;">
 * <li>Description : description</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2020/2/10 4:04 PM</li>
 * <li>Author      : ksice_xt</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@Service
@Transactional(rollbackFor = {Throwable.class})
public class CustomModelServiceImpl implements CustomModelService {

}
