package com.example.marco.ec_android;

import com.example.marco.ec_android.api.models.Project;
import com.example.marco.ec_android.api.models.User;

import okhttp3.logging.HttpLoggingInterceptor;

public class Conf {
    // Logger
    public static final HttpLoggingInterceptor.Level HTTP_LOGGING_LEVEL = BuildConfig.LOG_ENABLE ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE;
    // Api
    public static final String API_BASE_URL = "http://218.161.115.117:1234/";
    private static Project createProject;

    public static User GetUser() {
        User user = new User();
        user.id = "1";
        user.email = "bb@gmail.com";
        user.address = "高雄市鼓山區";
        user.phone = "0900111222";
        user.name = "周星星";
        return user;
    }

    public static void setProject(Project project) {
        if (createProject == null)
            createProject = new Project();
        createProject = project;
    }

    public static Project GetProject() {
        if (createProject == null)
            createProject = new Project();
        return createProject;
    }


}
