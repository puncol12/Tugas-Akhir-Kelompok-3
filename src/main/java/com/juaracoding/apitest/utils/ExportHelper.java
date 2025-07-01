package com.juaracoding.apitest.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import com.juaracoding.apitest.DriverSingleton;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ExportHelper {

    public static void downloadExportFile(String downloadPath, String fileName, String fullname, String nik) {
        String cookieValue = DriverSingleton.createOrGetDriver()
            .manage()
            .getCookieNamed("hadir_web_magang")
            .getValue();

        String url = "https://magang.dikahadir.com/api/users/export-users";
        if (fullname != null && !fullname.isEmpty()) {
            url += "?fullname=" + fullname;
        }
        if (nik != null && !nik.isEmpty()) {
            url += url.contains("?") ? "&nik=" + nik : "?nik=" + nik;
        }

        System.err.println("URL dipanggil" + url);

        Response response = RestAssured
            .given()
            .header("Cookie", "hadir_web_magang=" + cookieValue)
            .when()
            .get(url)
            .then()
            .statusCode(200)
            .extract()
            .response();

        byte[] fileBytes = response.asByteArray();

        try (FileOutputStream fos = new FileOutputStream(downloadPath + "/" + fileName)) {
            fos.write(fileBytes);
            System.out.println("Download sukses ke: " + downloadPath + "/" + fileName);
        } catch (IOException e) {
            throw new RuntimeException("Gagal simpan file", e);
        }
    }
}
