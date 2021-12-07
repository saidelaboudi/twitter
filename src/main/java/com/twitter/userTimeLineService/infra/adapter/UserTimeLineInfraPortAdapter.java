package com.twitter.userTimeLineService.infra.adapter;

import com.twitter.userTimeLineService.domain.port.infra.IUserTimeLineInfraPort;
import com.twitter.userTimeLineService.infra.service.IUserTimeLineService;

public class UserTimeLineInfraPortAdapter implements IUserTimeLineInfraPort {
    IUserTimeLineService userTimeLineService;


}
