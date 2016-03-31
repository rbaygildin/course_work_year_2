package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.*;
import org.egdeveloper.service.IDoctorService;
import org.egdeveloper.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Set;

@Controller
@SessionAttributes(value = {"doctorAccount", "patient"})
public class PatientEditorController {

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @RequestMapping(value = "/createPatientEntry", method = RequestMethod.GET)
    public String getPatientInfoEditor(@ModelAttribute("doctorAccount") Doctor doctor, ModelMap modelMap){
        modelMap.addAttribute("patientEntry", new Patient());
        return "PatientPages/PatientEditPage";
    }

    @RequestMapping(value = "/createPatientEntry", method = RequestMethod.POST)
    public String createPatientEntry(@ModelAttribute("patientEntry") @Valid Patient patient,
                                  BindingResult bindingResult, ModelMap modelMap, HttpSession session, SessionStatus sessionStatus)
    {
        Doctor doctor = (Doctor)session.getAttribute("doctorAccount");
        if(bindingResult.hasErrors()) {
            return "PatientPages/PatientEditPage";
        }
        patientService.addPatient(doctor, patient);
        sessionStatus.setComplete();
        return "redirect:/main";
    }

    @RequestMapping(value = "/updatePatientEntry", method = RequestMethod.POST)
    public String updatePatientEntry(@ModelAttribute("patient") @Valid Patient patient,
                                     BindingResult bindingResult, ModelMap modelMap, HttpSession session)
    {
        if(!bindingResult.hasErrors())
            patientService.editPatientInfo(patient);
        return "redirect:/personalPatientPage";
    }

    @RequestMapping(value = "/personalPatientPage", method = RequestMethod.GET)
    public String getPersonalPatientPage(@ModelAttribute("patient") Patient patient, ModelMap modelMap){
        return "PatientPages/PersonalPatientPage";
    }

    //get methods


    @RequestMapping(value = "/addBiochemTest", method = RequestMethod.GET)
    public String addBiochemTest(ModelMap modelMap)
    {
        modelMap.addAttribute("biochemTest", new BioChemTest());
        return "PatientPages/BiochemTestPage";
    }

    @RequestMapping(value = "/addCommonBloodTest", method = RequestMethod.GET)
    public String addCommonBloodTest(ModelMap modelMap)
    {
        modelMap.addAttribute("commonBloodTest", new CommonBloodTest());
        return "PatientPages/CommonBloodTestPage";
    }

    @RequestMapping(value = "/addCommonUreaTest", method = RequestMethod.GET)
    public String addCommonUreaTest(ModelMap modelMap)
    {
        modelMap.addAttribute("commonUreaTest", new CommonUreaTest());
        return "PatientPages/CommonUreaTestPage";
    }

    @RequestMapping(value = "/addDailyExcreationTest", method = RequestMethod.GET)
    public String addDailyExcreationTest(ModelMap modelMap)
    {
        modelMap.addAttribute("dailyExcreationTest", new DailyExcreationTest());
        return "PatientPages/DailyExcreationTestPage";
    }

    @RequestMapping(value = "/addTitrationTest", method = RequestMethod.GET)
    public String addTitrationTest(ModelMap modelMap)
    {
        modelMap.addAttribute("titrationTest", new TitrationTest());
        return "PatientPages/TitrationTestPage";
    }

    @RequestMapping(value = "/addUreaColorTest", method = RequestMethod.GET)
    public String addUreaColorTest(ModelMap modelMap)
    {
        modelMap.addAttribute("ureaColorTest", new UreaColorTest());
        return "PatientPages/UreaColorTestPage";
    }

    @RequestMapping(value = "/addUreaStoneTest", method = RequestMethod.GET)
    public String addUreaStoneTest(ModelMap modelMap)
    {
        modelMap.addAttribute("ureaStoneTest", new UreaStoneTest());
        return "PatientPages/UreaStoneTestPage";
    }

    //post methods

    @RequestMapping(value = "/addBiochemTest", method = RequestMethod.POST)
    public String addBiochemTest(@ModelAttribute("biochemTest") @Valid BioChemTest test,
                                 BindingResult bindingResult,
                                 ModelMap modelMap, HttpSession session)
    {
        if(!bindingResult.hasErrors()){
            Patient patient = (Patient)session.getAttribute("patient");
            if(patient != null){
                Set<BioChemTest> bioChemTests = patient.getBioChemTests();
                bioChemTests.add(test);
                patient.setBioChemTests(bioChemTests);
                patientService.editPatientInfo(patient);
                return "redirect:/personalPatientPage";
            }
        }
        return "redirect:/addBiochemTest";
    }

    @RequestMapping(value = "/addCommonBloodTest", method = RequestMethod.POST)
    public String addCommonBloodTest(@ModelAttribute("commonBloodTest") @Valid CommonBloodTest test,
                                     BindingResult bindingResult,
                                     ModelMap modelMap, HttpSession session)
    {
        if(!bindingResult.hasErrors()){
            Patient patient = (Patient)session.getAttribute("patient");
            if(patient != null){
                Set<CommonBloodTest> commonBloodTests = patient.getCommonBloodTests();
                commonBloodTests.add(test);
                patient.setCommonBloodTests(commonBloodTests);
                patientService.editPatientInfo(patient);
                return "redirect:/personalPatientPage";
            }
        }
        return "redirect:/addCommonBloodTest";
    }

    @RequestMapping(value = "/addCommonUreaTest", method = RequestMethod.POST)
    public String addCommonUreaTest(@ModelAttribute("commonUreaTest") @Valid CommonUreaTest test,
                                    BindingResult bindingResult,
                                    ModelMap modelMap, HttpSession session)
    {
        if(!bindingResult.hasErrors()){
            Patient patient = (Patient)session.getAttribute("patient");
            if(patient != null){
                Set<CommonUreaTest> commonUreaTests = patient.getCommonUreaTests();
                commonUreaTests.add(test);
                patient.setCommonUreaTests(commonUreaTests);
                patientService.editPatientInfo(patient);
                return "redirect:/personalPatientPage";
            }
        }
        return "redirect:/addCommonUreaTest";
    }

    @RequestMapping(value = "addDailyExcreationTest", method = RequestMethod.POST)
    public String addDailyExcreationTest(@ModelAttribute("dailyExcreationTest") @Valid DailyExcreationTest test,
                                         BindingResult bindingResult,
                                         ModelMap modelMap, HttpSession session)
    {
        if(!bindingResult.hasErrors()){
            Patient patient = (Patient)session.getAttribute("patient");
            if(patient != null){
                Set<DailyExcreationTest> dailyExcreationTests = patient.getDailyExcreationTests();
                dailyExcreationTests.add(test);
                patient.setDailyExcreationTests(dailyExcreationTests);
                patientService.editPatientInfo(patient);
                return "redirect:/personalPatientPage";
            }
        }
        return "redirect:/addDailyExcreationTest";
    }

    @RequestMapping(value = "addTitrationTest", method = RequestMethod.POST)
    public String addTitrationTest(@ModelAttribute("titrationTest") @Valid TitrationTest test,
                                   BindingResult bindingResult,
                                   ModelMap modelMap, HttpSession session)
    {
        if(!bindingResult.hasErrors()){
            Patient patient = (Patient)session.getAttribute("patient");
            if(patient != null){
                Set<TitrationTest> titrationTests = patient.getTitrationTests();
                titrationTests.add(test);
                patient.setTitrationTests(titrationTests);
                patientService.editPatientInfo(patient);
                return "redirect:/personalPatientPage";
            }
        }
        return "redirect:/addTitrationTest";
    }

    @RequestMapping(value = "addUreaColorTest", method = RequestMethod.POST)
    public String addUreaColorTest(@ModelAttribute("ureaColorTest") @Valid UreaColorTest test,
                                   BindingResult bindingResult,
                                   ModelMap modelMap, HttpSession session)
    {
        if(!bindingResult.hasErrors()){
            Patient patient = (Patient)session.getAttribute("patient");
            if(patient != null){
                Set<UreaColorTest> ureaColorTests = patient.getUreaColorTests();
                ureaColorTests.add(test);
                patient.setUreaColorTests(ureaColorTests);
                patientService.editPatientInfo(patient);
                return "redirect:/personalPatientPage";
            }
        }
        return "redirect:/addUreaColorTest";
    }

    @RequestMapping(value = "addUreaStoneTest", method = RequestMethod.POST)
    public String addUreaStoneTest(@ModelAttribute("ureaStoneTest") @Valid UreaStoneTest test,
                                   BindingResult bindingResult,
                                   ModelMap modelMap, HttpSession session)
    {
        if(!bindingResult.hasErrors()){
            Patient patient = (Patient)session.getAttribute("patient");
            if(patient != null){
                Set<UreaStoneTest> ureaStoneTests = patient.getUreaStoneTests();
                ureaStoneTests.add(test);
                patient.setUreaStoneTests(ureaStoneTests);
                patientService.editPatientInfo(patient);
                return "redirect:/personalPatientPage";
            }
        }
        return "redirect:/addUreaStoneTest";
    }

    @RequestMapping(value = "/viewMedicalTest/{testName}/{testID}", method = RequestMethod.GET)
    public String showMedicalTestInfo(@PathVariable("testName") String testName,
                                      @PathVariable("testID") Integer testID,
                                      ModelMap modelMap,
                                      HttpSession session)
    {
        Patient patient = (Patient) session.getAttribute("patient");
        MedicalTest medicalTest = null;
        if(testName.equals("bioChemTest"))
            medicalTest = patient.getBioChemTests().stream().filter(t -> testID == t.getId()).findFirst().get();
        if(testName.equals("commonBloodTest"))
            medicalTest = patient.getCommonBloodTests().stream().filter(t -> testID == t.getId()).findFirst().get();
        if(testName.equals("commonUreaTest"))
            medicalTest = patient.getCommonUreaTests().stream().filter(t -> testID == t.getId()).findFirst().get();
        if(testName.equals("dailyExcreationTest"))
            medicalTest = patient.getDailyExcreationTests().stream().filter(t -> testID == t.getId()).findFirst().get();
        if(testName.equals("titrationTest"))
            medicalTest = patient.getTitrationTests().stream().filter(t -> testID == t.getId()).findFirst().get();
        if(testName.equals("ureaColorTest"))
            medicalTest = patient.getUreaColorTests().stream().filter(t -> testID == t.getId()).findFirst().get();
        if(testName.equals("ureaStoneTest"))
            medicalTest = patient.getUreaStoneTests().stream().filter(t -> testID == t.getId()).findFirst().get();
        if(medicalTest != null) {
            modelMap.put("medicalTest", medicalTest);
            return "TestPages/View" + testName.substring(0, 1).toUpperCase() + testName.substring(1) + "Page";
        }
        return "redirect:/personalPatientPage";
    }
}
