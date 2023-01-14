package com.example.demo.controller

import io.micrometer.common.util.StringUtils;
import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
class MainController {

    private fun setUserInfo(response: JSONObject): JSONObject {
        response.put("name", "심지훈")
        response.put("age", 25)
        return response
    }

    @GetMapping("/get")
    fun processGetRequest(
            @RequestParam(value = "username", required = false) memberId: String?,
            @RequestParam(required = false) password: String?
    ): String? {
        var response: JSONObject = JSONObject().put("success", false)
        if (StringUtils.isNotBlank(memberId) && StringUtils.isNotBlank(password)) {
            response = setUserInfo(response)
            response.put("success", true)
        }
        return response.toString()
    }

    @PostMapping("/post")
    fun processPostRequest(
            @RequestParam(value = "username", required = false) memberId: String?,
            @RequestParam(required = false) password: String?
    ): String? {
        var response: JSONObject = JSONObject().put("success", false)
        if (StringUtils.isNotBlank(memberId) && StringUtils.isNotBlank(password)) {
            response = setUserInfo(response)
            response.put("success", true)
        }
        return response.toString()
    }

    @ResponseBody
    @PostMapping("/postjson")
    fun processPostJsonRequest(
            @RequestBody params: HashMap<String?, Any?>
    ): String? {
        var response: JSONObject = JSONObject().put("success", false)
        if (StringUtils.isNotBlank(params["username"] as String?)
                && StringUtils.isNotBlank(params["password"] as String?)) {
            response = setUserInfo(response)
            response.put("success", true)
        }
        return response.toString()
    }
}