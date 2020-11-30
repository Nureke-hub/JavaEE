package DB;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static Long id = 13L;

    static {
        tickets.add(new Ticket(1L, "Almaty", "Astana", 5000, 4));
        tickets.add(new Ticket(2L, "Almaty", "Taraz", 2000, 1));
        tickets.add(new Ticket(3L, "Taraz", "Astana", 3000, 2));
        tickets.add(new Ticket(4L, "Astana", "Aktobe", 3500, 3));
        tickets.add(new Ticket(5L, "Shymkent", "Karaganda", 3500, 3));
        tickets.add(new Ticket(6L, "Karaganda", "Aktay", 3500, 3));
        tickets.add(new Ticket(7L, "Aktay", "Almaty", 3500, 3));
        tickets.add(new Ticket(8L, "Uskaman", "Uralsk", 3500, 3));
        tickets.add(new Ticket(9L, "Uralsk", "Taldykorgan", 3500, 3));
        tickets.add(new Ticket(10L, "Taldykorgan", "Astana", 3500, 3));
        tickets.add(new Ticket(11L, "Usharal", "Semey", 3500, 3));
        tickets.add(new Ticket(12L, "Semey", "Almaty", 3500, 3));
    }

    public static void addTicket(Ticket ticket){
        ticket.setId(id);
        tickets.add(ticket);
        id++;
    }

    public static Ticket getTicket(Long id){
        for (Ticket t: tickets) {
            if(t.getId() == id){
                return t;
            }
        }
        return new Ticket();
    }

    public static ArrayList<Ticket> getAllTickets(){
        return tickets;
    }

    public static ArrayList<Ticket> getTicketsFromRange(int fromIndex){
        try{
            ArrayList<Ticket> ticketsFromRange = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                ticketsFromRange.add(tickets.get(fromIndex));
                fromIndex++;
                if(fromIndex == tickets.size()){
                    break;
                }
            }
            return ticketsFromRange;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void deleteTicket(Long id){
        Ticket t = getTicket(id);
        tickets.remove(t);
    }

    public static int getPagination(){
        if(tickets.size()%3 == 0){
            return tickets.size()/3;
        }else{
            return (tickets.size()/3) + 1;
        }

    }
}
