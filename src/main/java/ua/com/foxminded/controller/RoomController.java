package ua.com.foxminded.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.foxminded.model.Room;
import ua.com.foxminded.service.impl.RoomServiceImpl;

@Controller
public class RoomController {

    @Autowired
    RoomServiceImpl roomService;

    @GetMapping("/rooms")
    public String getRooms(Model model){
        model.addAttribute("rooms", roomService.getRooms());

        return "rooms";
    }

    @GetMapping("/rooms/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteRoom(@PathVariable("id") Integer id){
        roomService.deleteRoom(id);

        return "redirect:/rooms";
    }

    @GetMapping("/rooms/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String updateRoom(@PathVariable("id") Integer id, Model model){
        Room room = roomService.getRoom(id).get();
        model.addAttribute("room", room);

        return "room-edit";
    }

    @PostMapping("/rooms/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveUpdatedRoom(@PathVariable("id") Integer id, Room room){
        room.setId(id);
        roomService.updateRoom(room);

        return "redirect:/rooms";
    }

    @GetMapping("/rooms/new")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String showCreateRoomForm(Model model){
        Room room = new Room();
        model.addAttribute("room", room);

        return "room-create";
    }

    @PostMapping("/rooms/save")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public String saveRoom(@ModelAttribute Room room, Model model){
        model.addAttribute("room", room);
        roomService.addRoom(room);

        return "redirect:/rooms";
    }
}
