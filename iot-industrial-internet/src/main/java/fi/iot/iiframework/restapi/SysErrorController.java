/*
 * IoT - Industrial Internet Framework
 * Apache License Version 2.0, January 2004
 * Released as a part of Helsinki University
 * Software Engineering Lab in summer 2015
 */
package fi.iot.iiframework.restapi;

import fi.iot.iiframework.application.ApplicationSettings;
import fi.iot.iiframework.domain.Sensor;
import fi.iot.iiframework.errors.SysError;
import fi.iot.iiframework.errors.service.ErrorService;
import fi.iot.iiframework.restapi.exceptions.InvalidParametersException;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("1.0/errors")
public class SysErrorController {

    @Autowired
    private ErrorService errorservice;

    @Autowired
    private RestAPIHelper helper;

    @Autowired
    private ApplicationSettings settings;

    @Autowired
    private CriterionFactory criterionfactory;

    @RequestMapping(value = "/{errorid}/view", produces = "application/json")
    @ResponseBody
    public SysError getError(
            @PathVariable String errorid,
            @RequestParam(required = false) Map<String, String> params
    ) {
        return errorservice.get(errorid);
    }

    @RequestMapping(value = "/list", produces = "application/json")
    @ResponseBody
    public List<SysError> listErrors(
            @RequestParam(required = false) Map<String, String> params
    ) {
        return errorservice.getBy(0, settings.getDefautAmountOfErrorsRetrievedFromDatabase(), createCriterion(params));
    }

    @RequestMapping(value = "/list/{amount}", produces = "application/json")
    @ResponseBody
    public List<SysError> listErrorsAmount(
            @PathVariable int amount,
            @RequestParam(required = false) Map<String, String> params
    ) throws InvalidParametersException {
        helper.exceptionIfWrongLimits(0, amount);
        return errorservice.getBy(0, amount, createCriterion(params));
    }

    @RequestMapping(value = "/list/{from}/{to}", produces = "application/json")
    @ResponseBody
    public List<SysError> listErrorsFromTo(
            @PathVariable int from,
            @PathVariable int to,
            @RequestParam(required = false) Map<String, String> params
    ) throws InvalidParametersException {
        helper.exceptionIfWrongLimits(from, to);
        return errorservice.getBy(from, to, createCriterion(params));
    }

    private List<Criterion> createCriterion(Map<String, String> params) {
        return criterionfactory.getSysErrorCriterion(params);
    }
}