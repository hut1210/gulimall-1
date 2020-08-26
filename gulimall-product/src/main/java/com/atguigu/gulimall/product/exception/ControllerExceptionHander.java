package com.atguigu.gulimall.product.exception;

import com.atguigu.common.exception.BizCodeEnume;
import com.atguigu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
@Slf4j
public class ControllerExceptionHander {


    /**
     * 精确匹配处理controller参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R HandlerParamValdaterEx(MethodArgumentNotValidException e){

        log.error("参数出现异常： {}，异常类型： {}",e.getMessage(),e.getClass());

        BindingResult result = e.getBindingResult();
        Map<String,String> map = new HashMap<String, String>();
        if(result.hasErrors()){
            result.getFieldErrors().forEach((item) ->{
                String field = item.getField();
                String defaultMessage = item.getDefaultMessage();
                map.put(field,defaultMessage);

            });

        }
        return R.error(BizCodeEnume.VAILD_EXCEPTION.getCode(),BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data",map);
    }


    /**
     * 其他异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public R handlerException(Throwable e){
        log.error("参数出现异常： {}，异常类型： {}",e.getMessage(),e.getClass());
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }



}
