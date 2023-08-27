package com.admin.scannerproject.utils;


import com.admin.scannerproject.user.AssetEntity;
import com.admin.scannerproject.user.UserEntity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import com.google.zxing.client.j2se.MatrixToImageWriter;

public class QrCodeGenerator {

    public static void generateQrCode(UserEntity employee) throws WriterException, IOException {
    	String qrCodePath="E:\\";
        String qrCodeName=qrCodePath+employee.getId()+employee.getEmployeename()+employee.getEmployeedesignation()+employee.getEmailid() +"-QRCODE.png";
        
        //String qrCodePath = "E:\\";
       // String qrCodeName = qrCodePath + /* construct QR code name */;
        
        String qrCodeContent = "{\"id\":" + employee.getId() +
                ",\"employeename\":\"" + employee.getEmployeename() +
                "\",\"emailid\":\"" + employee.getEmailid() +
                "\",\"employeedesignation\":\"" + employee.getEmployeedesignation() +
                "\",\"password\":" + employee.getPassword() + "}";

        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, 400, 400);
        
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
        
        // Update the UserEntity object with the QR code name
//        employee.setQrCodeId(qrCodeName);
    }
}
