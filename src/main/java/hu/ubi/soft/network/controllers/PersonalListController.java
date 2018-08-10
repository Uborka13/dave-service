package hu.ubi.soft.network.controllers;

import hu.ubi.soft.database.beers.dtos.Beers;
import hu.ubi.soft.database.beers.repositories.BeersRepository;
import hu.ubi.soft.database.personallists.dto.PersonalListItemRelations;
import hu.ubi.soft.database.personallists.dto.PersonalLists;
import hu.ubi.soft.database.personallists.repository.PersonalListItemRelationsRepository;
import hu.ubi.soft.database.personallists.repository.PersonalListsRepository;
import hu.ubi.soft.database.users.dto.Users;
import hu.ubi.soft.database.users.repository.UsersRepository;
import hu.ubi.soft.network.exceptions.BeerItemAlreadyExistInThisList;
import hu.ubi.soft.network.exceptions.PersonalListNotFoundException;
import hu.ubi.soft.network.exceptions.UserNotFoundException;
import hu.ubi.soft.network.request.personallist.BeerItemList;
import hu.ubi.soft.network.request.personallist.PersonalList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/personalList")
public class PersonalListController {

    @Autowired
    private BeersRepository beersRepository;
    @Autowired
    private PersonalListItemRelationsRepository personalListItemRelationsRepository;
    @Autowired
    private PersonalListsRepository personalListsRepository;
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping
    public @ResponseBody
    Users createPersonalList(@RequestHeader(name = "userId") Long userId, @ModelAttribute PersonalList request) {
        HashSet<PersonalLists> hs = new HashSet<>();
        Users u = usersRepository.findByUserId(userId);
        if (u == null) {
            throw new UserNotFoundException(userId);
        }
        hs.add(new PersonalLists(u, request.getListName()));
        u.setPersonalLists(hs);
        return usersRepository.save(u);
    }

    @GetMapping
    public @ResponseBody
    Iterable<PersonalLists> getPersonalLists() {
        return personalListsRepository.findAll();
    }

    @PostMapping("/{personalListId}/addItemList")
    public @ResponseBody
    PersonalLists addBeerItemListToPersonalList(@RequestHeader(name = "userId") Long userId, @PathVariable Long personalListId, @ModelAttribute BeerItemList request) {
        Users u = usersRepository.findByUserId(userId);
        if (u == null) {
            throw new UserNotFoundException(userId);
        }
        PersonalLists pl = personalListsRepository.findByPersonalListId(personalListId);
        if (pl == null) {
            throw new PersonalListNotFoundException(personalListId);
        }
        return null;
    }

    @PostMapping("/{personalListId}/addItem/{beerItemId}")
    public @ResponseBody
    PersonalListItemRelations addBeerItemToPersonalList(@RequestHeader(name = "userId") Long userId, @PathVariable Long personalListId, @PathVariable Long beerItemId) throws BeerItemAlreadyExistInThisList {
        Users u = usersRepository.findByUserId(userId);
        if (u == null) {
            throw new UserNotFoundException(userId);
        }
        PersonalLists pl = personalListsRepository.findByPersonalListId(personalListId);
        if (pl == null) {
            throw new PersonalListNotFoundException(personalListId);
        }

        PersonalListItemRelations plir = new PersonalListItemRelations(personalListId, beerItemId);
        try {
            return personalListItemRelationsRepository.save(plir);
        } catch (Exception e) {
            if (e instanceof DataIntegrityViolationException) {
                throw new BeerItemAlreadyExistInThisList();
            } else {
                throw e;
            }

        }
    }

    @GetMapping("/{personalListId}")
    public @ResponseBody
    List<Beers> getBeerItemsOfAPersonalList(@RequestHeader(name = "userId") Long userId, @PathVariable Long personalListId) {
        Users u = usersRepository.findByUserId(userId);
        if (u == null) {
            throw new UserNotFoundException(userId);
        }
        PersonalLists pl = personalListsRepository.findByPersonalListId(personalListId);
        if (pl == null) {
            throw new PersonalListNotFoundException(personalListId);
        }
        List<Long> list = personalListItemRelationsRepository.findByPersonalListId(personalListId).stream().map(PersonalListItemRelations::getBeerItemId).collect(Collectors.toList());
        List<Beers> lista = beersRepository.findByBeerIdIn(list);
        System.out.println(lista.get(0).getBeerTypes());
        return beersRepository.findByBeerIdIn(list);

    }
}
