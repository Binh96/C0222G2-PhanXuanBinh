package controller;

import model.*;
import service.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "HomePageServlet", urlPatterns = "")
public class HomePageServlet extends HttpServlet {
    ITrangThaiMatBangService trangThaiMatBangService = new TrangThaiMatBangServiceImpl();
    IMatBangService matBangService = new MatBangServiceImpl();
    IToaNhaService toaNhaService = new ToaNhaServiceImpl();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addToaNha(request, response);
                break;
            case "edit":
//                updateToaNha(request, response);
                break;
            default:
                showPage(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                showPageAddToaNha(request, response);
                break;
            case "edit":
//                showPageUpdateToaNha(request, response);
                break;
            case "delete":
                deleteToaNha(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showPage(request, response);
                break;
        }
    }

    private void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<MatBang> matBangs = matBangService.selectAll();
        List<TrangThaiMatBang> trangThaiMatBangs = trangThaiMatBangService.selectAll();
        List<ToaNha> toaNhas = toaNhaService.selectAll();

        request.setAttribute("matBangs", matBangs);
        request.setAttribute("trangThais", trangThaiMatBangs);
        request.setAttribute("toaNhas", toaNhas);
        request.getRequestDispatcher("/object/list.jsp").forward(request, response);
    }

    private void showPageAddToaNha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<MatBang> matBangs = matBangService.selectAll();
        List<TrangThaiMatBang> trangThaiMatBangs = trangThaiMatBangService.selectAll();

        request.setAttribute("matBangs", matBangs);
        request.setAttribute("trangThais", trangThaiMatBangs);
        request.getRequestDispatcher("/object/insert.jsp").forward(request, response);
    }

    private void addToaNha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String maMatBang = request.getParameter("maMatBang");
        Integer haTang = Integer.parseInt(request.getParameter("haTang"));
        Double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        Integer soTang = Integer.parseInt(request.getParameter("soTang"));
        Integer loaiMatBang = Integer.parseInt(request.getParameter("loaiVanPhong"));
        String desc = request.getParameter("desc");
        Integer giaTien = Integer.parseInt(request.getParameter("gia"));
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");

        ToaNha toaNha = new ToaNha(maMatBang, haTang, dienTich, soTang, loaiMatBang, desc, giaTien, ngayBatDau, ngayKetThuc);
        toaNhaService.insert(toaNha);
        response.sendRedirect("/");
//        Map<String, String> errors = toaNhaService.insert(toaNha);
//
//        if(errors.isEmpty()){
//            response.sendRedirect("/");
//        }
//        else{
//            request.setAttribute("maMatBang", maMatBang);
//            request.setAttribute("dienTich", dienTich);
//            request.setAttribute("haTang", haTang);
//            request.setAttribute("soTang", soTang);
//            request.setAttribute("loaiVanPhong", loaiMatBang);
//            request.setAttribute("desc", desc);
//            request.setAttribute("gia", giaTien);
//            request.setAttribute("ngayBatDau", ngayBatDau);
//            request.setAttribute("ngayKetThuc", ngayKetThuc);
//
//            List<MatBang> matBangs = matBangService.selectAll();
//            List<TrangThaiMatBang> trangThaiMatBangs = trangThaiMatBangService.selectAll();
//
//            request.setAttribute("matBangs", matBangs);
//            request.setAttribute("trangThais", trangThaiMatBangs);
//            request.getRequestDispatcher("object/insert.jsp").forward(request, response);
//        }
    }
//
//    private void showPageUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        List<Catagory> catagories = catagoryService.selectAll();
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = productService.selectById(id);
//
//        request.setAttribute("id", id);
//        request.setAttribute("name", product.getNameProduct());
//        request.setAttribute("price", product.getPriceProduct());
//        request.setAttribute("quantity", product.getQuantity());
//        request.setAttribute("color", product.getColorProduct());
//        request.setAttribute("desc", product.getDescProduct());
//        request.setAttribute("catagory", product.getCatagory());
//        request.setAttribute("catagories", catagories);
//
//        request.getRequestDispatcher("/object/update.jsp").forward(request, response);
//    }
//
//    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        String name = request.getParameter("name");
//        Integer price = Integer.parseInt(request.getParameter("price"));
//        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
//        String color = request.getParameter("color");
//        String desc = request.getParameter("desc");
//        Integer catagory = Integer.parseInt(request.getParameter("catagory"));
//
//        Product product = new Product(name, price, quantity, color, desc, catagory);
//        productService.update(id, product);
//
//        response.sendRedirect("/");
//    }
//
    private void deleteToaNha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String maMatBang = request.getParameter("id");
        toaNhaService.delete(maMatBang);
        response.sendRedirect("/");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String matBangSearch = request.getParameter("matBangSearch");
        String trangThaiSearch = request.getParameter("trangThaiSearch");
        String maMatBang = request.getParameter("maMatBang");

        List<MatBang> matBangs = matBangService.selectAll();
        List<TrangThaiMatBang> trangThaiMatBangs = trangThaiMatBangService.selectAll();

        request.setAttribute("matBangs", matBangs);
        request.setAttribute("trangThais", trangThaiMatBangs);


        matBangSearch = "%" + matBangSearch + "%";
        trangThaiSearch = "%" + trangThaiSearch + "%";
        maMatBang = "%" + maMatBang + "%";
        List<ToaNha> toaNhas = toaNhaService.selectByManyAttribute(maMatBang, trangThaiSearch, matBangSearch);
        request.setAttribute("toaNhas", toaNhas);
        request.getRequestDispatcher("/object/list.jsp").forward(request,response);
    }










//            String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "edit":
//                String medicalRecordId = request.getParameter("idEdit");
//                String patientId = request.getParameter("patientId");
//                String patientName = request.getParameter("patientName");
//                String hospitalizedDayTemp = request.getParameter("hospitalizedDay");
//                String errHospitalizedDay = null;
//                Date hospitalizedDay = null;
//                try {
//                    hospitalizedDay = Date.valueOf(hospitalizedDayTemp);
//                } catch (IllegalArgumentException e) {
//                    errHospitalizedDay = "Vui lòng nhập đúng định dạng ngày (dd/MM/yyyy)";
//                } catch (Exception e) {
//                    errHospitalizedDay = "Vui lòng nhập đúng định dạng ngày (dd/MM/yyyy)";
//                }
//                String dischargeDayTemp = request.getParameter("dischargeDay");
//                String errDischargeDay = null;
//                Date dischargeDay = null;
//                try {
//                    dischargeDay = Date.valueOf(dischargeDayTemp);
//                } catch (IllegalArgumentException e) {
//                    errDischargeDay = "Sai định dạng ngày (dd/MM/yyyy)";
//                } catch (Exception e) {
//                    errDischargeDay = "Sai định dạng ngày (dd/MM/yyyy)";
//                }
//                String hospitalizedReason = request.getParameter("hospitalizedReason");
//                MedicalRecord medicalRecord = new MedicalRecord(medicalRecordId, patientId, hospitalizedDay, dischargeDay, hospitalizedReason);
//
//                Map<String, String> errMedicalRecord = new HashMap<>();
//
//                Map<String, String> errMap = new HashMap<>();
//                Map<String, String> errPatient = new HashMap<>();
//                if (errHospitalizedDay != null) {
//                    errMap.put("errHospitalizedDay", errHospitalizedDay);
//                } else {
//                    errMedicalRecord = medicalRecordService.editMedicalRecord(medicalRecord);
//                }
//                if (errDischargeDay != null) {
//                    errMap.put("errDischargeDay", errDischargeDay);
//                } else {
//                    errPatient = patientService.editPatient(medicalRecordId, patientId, patientName);
//                }
//                if (!errMedicalRecord.isEmpty()) {
//                    errMap.putAll(errMedicalRecord);
//                }
//                if (!errPatient.isEmpty()) {
//                    errMap.putAll(errPatient);
//                }
//
//                if (errMap.isEmpty()) {
//                    response.sendRedirect("home");
//                } else {
//                    List<Patient> patients = patientService.getAllPatients();
//                    for (Patient patient: patients) {
//                        if (patient.getPatientId().equals(medicalRecord.getPatientId())) {
//                            patient.setPatientName(patientName);
//                            break;
//                        }
//                    }
//                    request.setAttribute("listPatients", patients);
//                    request.setAttribute("medicalRecord", medicalRecord);
//                    request.setAttribute("errMap", errMap);
//                    request.getRequestDispatcher("edit.jsp").forward(request, response);
//                }
//                break;
//            default:
//                showListMedicalRecords(request, response);
//                break;
//        }

}
