package service;

import dao.*;
import dto.*;

import java.util.List;

public class PersonService {
    private final PersonalDataDAO personalDataDAO;
    private final PermanentAddressDAO permanentAddressDAO;
    private final PassportDAO passportDAO;
    private final TemporaryAddressDAO temporaryAddressDAO;
    private final PhoneDAO phoneDAO;
    private final PersonDAO personDAO;

    public PersonService() {
        this.personalDataDAO = new PersonalDataDAO();
        this.permanentAddressDAO = new PermanentAddressDAO();
        this.passportDAO = new PassportDAO();
        this.temporaryAddressDAO = new TemporaryAddressDAO();
        this.phoneDAO = new PhoneDAO();
        this.personDAO = new PersonDAO();
    }

    public void insert(PersonDTO personDTO) {
        PersonalDataCreateDTO personalDataCreateDTO = new PersonalDataCreateDTO(personDTO.getBirthDate(), personDTO.getName(), personDTO.getSurname());

        Long id = personalDataDAO.insertPersonalData(personalDataCreateDTO);

        PermanentAddressCreateDTO permanentAddressCreateDTO = new PermanentAddressCreateDTO(personDTO.getCityPer(), personDTO.getCountryPer(), personDTO.getDistrictPer(), personDTO.getFlatPer(), personDTO.getHomePer(), personDTO.getLiveFromPer(), personDTO.getRegionPer(), personDTO.getStreetPer(), id);

        permanentAddressDAO.insertPermanentAddress(permanentAddressCreateDTO);

        PassportCreateDTO passportCreateDTO = new PassportCreateDTO(personDTO.getExpired(), personDTO.getIssued(), personDTO.getIssuedBy(), personDTO.getNumber(), personDTO.getSeries(), id);

        passportDAO.insertPassport(passportCreateDTO);

        TemporaryAddressCreateDTO temporaryAddressCreateDTO = new TemporaryAddressCreateDTO(personDTO.getCityTemp(), personDTO.getCountryTemp(), personDTO.getDistrictTemp(), personDTO.getFlatTemp(), personDTO.getHomeTemp(), personDTO.getLiveFromTemp(), personDTO.getLiveToTemp(), personDTO.getRegionTemp(), personDTO.getStreetTemp(), id);

        temporaryAddressDAO.insertPermanentAddress(temporaryAddressCreateDTO);

        PhoneCreateDTO phoneCreateDTO = new PhoneCreateDTO(personDTO.getPhoneNumber(), id);

        phoneDAO.insertPhone(phoneCreateDTO);
    }

    public List<PersonReadDTO> select() {
        return personDAO.selectAllPersons();
    }

    public void delete(Long id){
        boolean personalDataDeleted = personalDataDAO.deletePersonalData(id);
        boolean permanentAddressDeleted = permanentAddressDAO.deletePermanentAddress(id);
        boolean passportDeleted = passportDAO.deletePassport(id);
        boolean temporaryAddressDeleted = temporaryAddressDAO.deleteTemporaryAddress(id);
        boolean phoneDeleted = phoneDAO.deletePhone(id);
    }

    public PersonReadDTO selectById(Long id){
        PersonalDataReadDTO personalDataReadDTO = personalDataDAO.selectPersonalDataById(id);
        PermanentAddressReadDTO permanentAddressReadDTO = permanentAddressDAO.selectPermanentAddressById(id);
        PassportReadDTO passportReadDTO = passportDAO.selectPassportById(id);
        TemporaryAddressReadDTO temporaryAddressReadDTO = temporaryAddressDAO.selectTemporaryAddressById(id);
        PhoneReadDTO phoneReadDTO = phoneDAO.selectPhoneById(id);

        PersonReadDTO personReadDTO = new PersonReadDTO(personalDataReadDTO.getId(), personalDataReadDTO.getBirthDate(), personalDataReadDTO.getName(), personalDataReadDTO.getSurname(),
                permanentAddressReadDTO.getCityPer(), permanentAddressReadDTO.getCountryPer(), permanentAddressReadDTO.getDistrictPer(), permanentAddressReadDTO.getFlatPer(), permanentAddressReadDTO.getHomePer(), permanentAddressReadDTO.getLiveFromPer(), permanentAddressReadDTO.getRegionPer(), permanentAddressReadDTO.getStreetPer(),
                passportReadDTO.getExpired(), passportReadDTO.getIssued(), passportReadDTO.getIssuedBy(), passportReadDTO.getNumber(), passportReadDTO.getSeries(),
                temporaryAddressReadDTO.getCityTemp(), temporaryAddressReadDTO.getCountryTemp(), temporaryAddressReadDTO.getDistrictTemp(), temporaryAddressReadDTO.getFlatTemp(), temporaryAddressReadDTO.getHomeTemp(), temporaryAddressReadDTO.getLiveFromTemp(), temporaryAddressReadDTO.getLiveToTemp(), temporaryAddressReadDTO.getRegionTemp(), temporaryAddressReadDTO.getStreetTemp(),
                phoneReadDTO.getPhoneNumber());
        return personReadDTO;
    }

    public void update(PersonReadDTO personReadDTO){
        PersonalDataReadDTO personalDataReadDTO = new PersonalDataReadDTO(personReadDTO.getId(), personReadDTO.getBirthDate(), personReadDTO.getName(), personReadDTO.getSurname());
        personalDataDAO.updatePersonalData(personalDataReadDTO);
        PermanentAddressCreateDTO permanentAddressCreateDTO = new PermanentAddressCreateDTO(personReadDTO.getCityPer(), personReadDTO.getCountryPer(), personReadDTO.getDistrictPer(), personReadDTO.getFlatPer(), personReadDTO.getHomePer(), personReadDTO.getLiveFromPer(), personReadDTO.getRegionPer(), personReadDTO.getStreetPer(), personReadDTO.getId());
        permanentAddressDAO.updatePermanentAddress(permanentAddressCreateDTO);
        PassportCreateDTO passportCreateDTO = new PassportCreateDTO(personReadDTO.getExpired(), personReadDTO.getIssued(), personReadDTO.getIssuedBy(), personReadDTO.getNumber(), personReadDTO.getSeries(), personReadDTO.getId());
        passportDAO.updatePassport(passportCreateDTO);
        TemporaryAddressCreateDTO temporaryAddressCreateDTO = new TemporaryAddressCreateDTO(personReadDTO.getCityTemp(), personReadDTO.getCountryTemp(), personReadDTO.getDistrictTemp(), personReadDTO.getFlatTemp(), personReadDTO.getHomeTemp(), personReadDTO.getLiveFromTemp(), personReadDTO.getLiveToTemp(), personReadDTO.getRegionTemp(), personReadDTO.getStreetTemp(), personReadDTO.getId());
        temporaryAddressDAO.updatePassport(temporaryAddressCreateDTO);
        PhoneCreateDTO phoneCreateDTO = new PhoneCreateDTO(personReadDTO.getPhoneNumber(), personReadDTO.getId());
        phoneDAO.updatePhone(phoneCreateDTO);
    }

}

