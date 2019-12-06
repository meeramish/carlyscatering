package CarlysCatering;



class Event {
    public final static double HighGuestPrice = 35.00;
    public final static double LowGuestPrice = 32.00;
    public final static int LargeEvent = 50;
    public final static int EventNumberLength = 4;
    public final static String[] EventTypes
            = {"Wedding", "Baptism", "Birthday", "Corporate", "Other"};
    private String EventNumber;
    private int Guests;
    private double PricePerGuest;
    private double PriceForEvent;
    private String ContactPhNumber;
    private int EventType;

    public Event() {
        this("A000", 0);
    }

    public Event(String num, int guests) {
        setEventNumber(num);
        setGuests(guests);
    }

    public void setEventNumber(String num) {
        if (num.length() != EventNumberLength || !Character.isLetter(num.charAt(0)) || !Character.isDigit(num.charAt(1))
                || !Character.isDigit(num.charAt(2)) || !Character.isDigit(num.charAt(3))) {
            EventNumber = "A000";
        } else {
            EventNumber = num.toUpperCase();
        }
    }

    public void setGuests(int gsts) {
        Guests = gsts;
        if (isLargeEvent()) {
            PricePerGuest = LowGuestPrice;
            PriceForEvent = Guests * LowGuestPrice;
        } else {
            PricePerGuest = HighGuestPrice;
            PriceForEvent = Guests * HighGuestPrice;
        }
    }

    public String getEventNumber() {
        return EventNumber;
    }

    public int getGuests() {
        return Guests;
    }

    public double getPriceForEvent() {
        return PriceForEvent;
    }

    public double getPricePerGuest() {
        return PricePerGuest;
    }

    public String getContactPhNumber() {
        String phone;
        phone = "(" + ContactPhNumber.substring(0, 3) + ") "
                + ContactPhNumber.substring(3, 6) + "-"
                + ContactPhNumber.substring(6, 10);
        return phone;
    }

    public void setContactPhNumber(String phone) {
        final int ValidLength = 10;
        final String inValidPhone = "0000000000";
        ContactPhNumber = "";
        int len = phone.length();
        for (int x = 0; x < len; ++x) {
            if (Character.isDigit(phone.charAt(x))) {
                ContactPhNumber += phone.charAt(x);
            }
        }
        if (ContactPhNumber.length() != ValidLength) {
            ContactPhNumber = inValidPhone;
        }
    }

    public void setEventType(int code) {
        if (code < EventTypes.length) {
            EventType = code;
        } else {
            EventType = EventTypes.length - 1;
        }
    }

    public int getEventType() {
        return EventType;
    }

    public String getEventTypeString() {
        return EventTypes[EventType];
    }

    public boolean isLargeEvent() {
        boolean isLarge = false;
        if (Guests >= LargeEvent) {
            isLarge = true;
        }
        return isLarge;
    }
}
