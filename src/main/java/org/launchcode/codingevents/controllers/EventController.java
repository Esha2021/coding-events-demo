package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.Eventdata;
import org.launchcode.codingevents.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

//    private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", Eventdata.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors,Model model) {
        if (errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
        Eventdata.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", Eventdata.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                Eventdata.remove(id);
            }
        }

        return "redirect:";
    }

@GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        // controller code will go here

    Event eventToEdit = Eventdata.getById(eventId);
    model.addAttribute("event", eventToEdit);
    String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
    model.addAttribute("title", title );
    return "events/edit";
    }

@PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        // controller code will go here
    Event eventToEdit = Eventdata.getById(eventId);
    eventToEdit.setName(name);
    eventToEdit.setDescription(description);
    return "redirect:";
    }
}
