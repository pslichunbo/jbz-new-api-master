package io.renren.common.utils;

/**
 * Created on 2017/3/11.
 */
public class Const {

    public static final String STR_REQUIRED = "required";
    
    public static final String REQUEST_ADMIN="admin";

    public static final int VERIFY_CODE_LENGTH = 5;

    public static final String IMG_FILE_DIR = "/file";
    public static final String DEFAULT_STR_SEPARATOR = ",";
    public static final String DATE_FORMAT = "yyyyMMdd";
    public static final String VERIFY_CODE_COOKIE_NAME = "v_c";

    public static final String REQUEST_USER_ID = "rest_request_user_id";
    public static final String REQUEST_IP = "request_ip";

    public interface Patterns{
        String PHONE = "^1[345678]\\d{9}$";
    }

    public interface Permission {
        /** 管理员 */
        String ADMIN = "ROLE_ADMIN";
        /** 登录用户 */
        String ROLE_USER = "ROLE_USER";
        /** 未登录用户 */
        String ROLE_ANONYMOUS ="ROLE_ANONYMOUS";
    }

    public interface Cache{
        String CONFIG = "config";
        String COLUMN = "column";
        String CONTENT = "content";
        String ARTICLE= "article";
        String COMMODITYBRAND ="commoditybrand";
        String CONVERSIONRECORD = "conversionRecord";
        String TEXTSEARCH = "textSearch";
        String GOLDRECORD = "goldRecord";
        String IDENTITYATTESTATION = "identityAttestation";
        String INDUSTRYINFO = "industryInfo";
        String LABEL = "label";
        String MACHINE = "machine";
        String MAINTENANCEPERSON = "maintenancePerson";
        String MAINTENANCESTORE = "maintenanceStore";
        String MENUNEXT = "menuNext";
        String MENUROOT = "menuRoot";
        String MERCHANT = "merchant";
        String MESSAGE = "message";
        String ORDERFORM = "orderForm";
        String PARTS ="parts";
        String PRESENT = "present";
        String PROPERTY = "property";
        String PROPERTYINFO = "maintenanceStore";
        String SOURCEGOODS ="sourceGoods";
        String USER = "user";
        String VIDEO = "video";
    }

    public interface XHeaders{
        String DATA_TOTAL_ELEMENTS = "X-Data-Total-Elements";
        String DATA_PAGE = "X-Data-Page";//request: required || (other), response: currentPageNumber
        String DATA_PAGESIZE = "X-Data-Pagesize";//request: required || (other), response: pagesize
        String DATA_HAS_MORE = "X-Data-Has-More";//request: required || (other), response: isHashMoreData
        String DATA_PAGE_CURSOR = "X-Data-Cursor";//response: currentPageCursor

        String AUTH_TOKEN = "X-Auth-Token";
        String PERMISSION_ADMIN = "X-Permission-Admin";
    }

}

