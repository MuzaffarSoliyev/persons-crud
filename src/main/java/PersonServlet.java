import dto.PersonDTO;
import dto.PersonReadDTO;
import service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


public class PersonServlet extends HttpServlet {

    private PersonService personService;

    @Override
    public void init() throws ServletException {
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                getPersonDataForInsert(request, response);
                break;
            case "/delete":
                deletePerson(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updatePerson(request, response);
                break;
            default:
                listPersons(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("new-person.jsp");
        dispatcher.forward(request, response);
    }

    private void getPersonDataForInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonDTO personDTO = PersonDTO.builder()
                .birthDate(LocalDate.parse(request.getParameter("BirthDate")))
                .name(request.getParameter("Name"))
                .surname(request.getParameter("Surname"))
                .cityPer(request.getParameter("CityPer"))
                .countryPer(request.getParameter("DistrictPer"))
                .flatPer(request.getParameter("FlatPer"))
                .homePer(request.getParameter("HomePer"))
                .liveFromPer(LocalDate.parse(request.getParameter("LiveFromPer")))
                .regionPer(request.getParameter("RegionPer"))
                .streetPer(request.getParameter("StreetPer"))
                .expired(LocalDate.parse(request.getParameter("Expired")))
                .issued(LocalDate.parse(request.getParameter("Issued")))
                .issuedBy(request.getParameter("IssuedBy"))
                .number(request.getParameter("Number"))
                .series(request.getParameter("Series"))
                .cityTemp(request.getParameter("CityTemp"))
                .countryTemp(request.getParameter("CountryTemp"))
                .districtTemp(request.getParameter("DistrictTemp"))
                .flatTemp(request.getParameter("FlatTemp"))
                .homeTemp(request.getParameter("HomeTemp"))
                .liveFromTemp(LocalDate.parse(request.getParameter("LiveFromTemp")))
                .liveToTemp(LocalDate.parse(request.getParameter("LiveToTemp")))
                .regionTemp(request.getParameter("RegionTemp"))
                .streetTemp(request.getParameter("StreetTemp"))
                .phoneNumber(request.getParameter("PhoneNumber"))
                .build();

        personService.insert(personDTO);
        response.sendRedirect("list");
    }


    private void listPersons(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PersonReadDTO> personReadDTOS = personService.select();
        request.setAttribute("listPersons", personReadDTOS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-of-persons.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        personService.delete(id);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        PersonReadDTO personReadDTO = personService.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-person.jsp");
        request.setAttribute("existingPerson", personReadDTO);
        dispatcher.forward(request, response);
    }

    private void updatePerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonReadDTO personReadDTO = PersonReadDTO.builder()
                .id(Long.parseLong(request.getParameter("id")))
                .birthDate(LocalDate.parse(request.getParameter("BirthDate")))
                .name(request.getParameter("Name"))
                .surname(request.getParameter("Surname"))
                .cityPer(request.getParameter("CityPer"))
                .countryPer(request.getParameter("CountryPer"))
                .districtPer(request.getParameter("DistrictPer"))
                .flatPer(request.getParameter("FlatPer"))
                .homePer(request.getParameter("HomePer"))
                .liveFromPer(LocalDate.parse(request.getParameter("LiveFromPer")))
                .regionPer(request.getParameter("RegionPer"))
                .streetPer(request.getParameter("StreetPer"))
                .expired(LocalDate.parse(request.getParameter("Expired")))
                .issued(LocalDate.parse(request.getParameter("Issued")))
                .issuedBy(request.getParameter("IssuedBy"))
                .number(request.getParameter("Number"))
                .series(request.getParameter("Series"))
                .cityTemp(request.getParameter("CityTemp"))
                .countryTemp(request.getParameter("CountryTemp"))
                .districtTemp(request.getParameter("DistrictTemp"))
                .flatTemp(request.getParameter("FlatTemp"))
                .homeTemp(request.getParameter("HomeTemp"))
                .liveFromTemp(LocalDate.parse(request.getParameter("LiveFromTemp")))
                .liveToTemp(LocalDate.parse(request.getParameter("LiveToTemp")))
                .regionTemp(request.getParameter("RegionTemp"))
                .streetTemp(request.getParameter("StreetTemp"))
                .phoneNumber(request.getParameter("PhoneNumber"))
                .build();

        personService.update(personReadDTO);
        response.sendRedirect("list");
    }

}
