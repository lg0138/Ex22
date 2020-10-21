package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    final static int ASIA = 1;
    final static int EUROPE = 2;
    final static int AFRICA = 3;
    final static int AMERICA = 4;

    String[] continents = {"Continent", "Asia", "Europe", "Africa", "America"};
    String[][] countries = {
            new String[] {},
            new String[] {"Country","India", "Turkey", "Japan", "Jordan", "Israel", "Lebanon", "China"},
            new String[] {"Country","Austria", "Belgium", "France", "Greece", "Poland", "Russia", "Sweden"},
            new String[] {"Country","Tunisia", "Egypt", "Ethiopia", "Kenya", "Sudan", "Uganda", "Morocco"},
            new String[] {"Country","Brazil", "Canada", "El Salvador", "Haiti", "Mexico", "Panama", "United States"}
    };

    // לכל מדינה:  שמות הערים שלה
    String[][] asiaCityNames = {
            {},
            {"Uttar Pradesh", "Maharashtra", "Clarified", "West Bengal", "Tamil Nadu"},
            {"Istanbul", "Ankara", "Antalya", "Adna", "Izmir"},
            {"Tokyo", "Kyoto", "Osaka", "Hiroshima", "Negoya"},
            {"Amman", "Jerash", "Aqaba", "Midba", "Irbid"},
            {"Jerusalem", "Bnei Brak", "Ramat Gan", "Beer Sheva", "Haifa"},
            {"Sidon", "Belbach", "Beirut", "Tripoli", "Tire"},
            {"Beijing", "Shanghai", "Wuhan", "Xian", "Hong Kong"},
    };
    // לכל עיר: מספר התושבים שטח
    String[][] asiaCityDetails = {
            {},
            {"166197988 240928km", "96878958 307,713km", "82998697 94163km", "82998697 88752km", "62405999 130158km"},
            {"14657434 1830.92km", "5503985 2516km", "2426356 1417km", "2220125 1945km", "4320519 855km"},
            {"13942856 2187.66km", "1466264 827.9km", "2740202 222.11km", "1306589 905.01km", "232918 326.45km"},
            {"4302730 1400km", "50745 410km", "140000 375km", "83180 39.4km", "1770158 410km"},
            {"874186 125.1km", "185882 7.088km", "153135 12.21km", "204707 117.5km", "279247 63.67km"},
            {"80000 7km", "105000 7km", "361366 85km", "229398 14km", "160000 5km"},
            {"21710000 16801.25km", "23390000 7,037km", "11895000 8494km", "5740000 9983km", "7496981 1050km"},
    };

    String[][] europeCityNames = {
            {},
            {"Vienna", "Innsbruck", "Grace", "Salzburg", "Klagenfurt"},
            {"Brussels", "Antwerp", "Bruges", "Ghent", "Namur"},
            {"Paris", "Marseille", "Nice", "Lyon", "Bordeaux"},
            {"Athens", "Thessaloniki", "Heraklion", "Peters", "Ioannina"},
            {"Warsaw", "Krakow", "Wroclaw", "Poznan", "Gdansk"},
            {"Saint Petersburg", "Moscow", "Sochi", "Anadir", "Norilsk"},
            {"Stockholm", "Gothenburg", "From Alma", "Kiruna", "Uppsala"},
    };

    String[][] europeCityDetails = {
            {},
            {"1888776 414.65km", "132493 104.91km", "289440 12,758km", "154076 65.7km", "101403 120.11km"},
            {"185103 32.61km", "529247 204.51", "118053 138.4km", "262,219 156.18km", "110939 175.69km"},
            {"2187526 105.4km", "855393 240.62km", "340017 71.92km", "516092 47.95km", "254436 49.36km"},
            {"664046 39km", "315196 17.80km", "140730 109.03km", "167446 125.40km", "65574 47.44km"},
            {"1790658 517.24km", "766739 327km", "638586 292.82km", "536438 261.85km", "464254 262km"},
            {"5351935 1439km", "12692466 2561.5km", "411524 3502km", "15604 53km", "179554 23.16km"},
            {"972647 377.30km", "600473 465km", "321845 335.10km", "16661 15.92km", "164535 47.86km"},
    };

    String[][] africaCityNames = {
            {},
            {"Tunis", "Spex", "Kairouan", "Gapsa", "Bizarte"},
            {"Alexandria", "Cairo", "Luxor", "Suez", "Fleece"},
            {"Addis Ababa", "Gondar", "Mount Dr", "Awsa", "Dava Apartment"},
            {"Nairobi", "Mombasa", "Lamu", "Kissimo", "Lodwar"},
            {"Wadi Halfa", "Omdurman", "Al Obeid", "Dongola", "Juba"},
            {"Kampala", "Entebbe", "Mbale", "Jinja", "Gulu"},
            {"Marrakech", "Fès", "Casablanca", "Rabat", "Meknès"},
    };

    String[][] africaCityDetails = {
            {},
            {"1200000 212.63km", "272801 56km", "187000 68.02km", "84676 45km", "142,966 34km"},
            {"4870000 2679km", "9293612 214km", "487896 416km", "565716 250,400,000km", "3021542 1579.75km"},
            {"3041002 530.15km", "323900 192.27km", "243300 213.43km", "300100 1708km", "277000 1,213.2km"},
            {"5545000 684km", "1200000 295km", "12839 0.37km", "259258 Unknown", "82970 Unknown"},
            {"1659600 189km", "69958 56200000km", "53634 Unknown", "72931 Unknown", "150306 Unknown"},
            {"928850 230km", "1112072 320km", "4370000 324km ", "572717 118km", "520428 370km"},
    };

    String[][] americaCityNames = {
            {},
            {"Rio de Janeiro", "Salvador", "Brasília", "Manaus", "São Paulo"},
            {"Toronto", "Vancouver", "Montreal", "Ottawa", "Quebec"},
            {"San Salvador", "Santa Ana", "Sonsonate", "Ahuachapán", "Apopa"},
            {"Gonaïves", "Jakmèl", " Jeremi", " Port-au-Prince", "Cap-Haïtien"},
            {"Ciudad de México", "Cancún", "Acapulco", "Ciudad Juárez", "Tijuana"},
            {"Ciudad de Panamá", "San José de David", "Boquete", "Anton Valley", "Las Tablas"},
            {"New York City", "Los Angeles", "Philadelphia", "Seattle", "Boston"},
    };

    String[][] americaCityDetails = {
            {},
            {"6520266 1183km", "2921087 706km", "3015268 5802km", "2020301 11401km", "12106920 1522.99km"},
            {"2731571 630km", "631486 114.67km", "1704694 431.50km", "934243 2778.64km", "531902 454.26km"},
            {"567698 72.27km", "264091 408.01km", "72158 232.53km", "110511 244.84km", "131286 51.84km"},
            {"300000 Unknown", "40000 Unknown", "34788 427.22km", "1082800 Unknown", "190289 53.5km"},
            {"8918653 1499km", "743626 1978.75km", "687608 1880.60km", "132100 221km", "1964788 637km"},
            {"880691 275km", "144858 176km", "19000 Unknown", "7602 34.8km", "9255 7.5km"},
            {"8398748 789km", "4100000 1290.6km", "1580863 369.59km", "608660 369.2km", "645966 232.1km"},
    };


    ListView cityListView;
    Spinner continentSpinner;
    Spinner countrySpinner;
    TextView populationSizeTextView;
    TextView areaTextView;

    int selectedContinentIndex;
    int selectedCountryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityListView = findViewById(R.id.cityListView);
        continentSpinner = findViewById(R.id.continentSpinner);
        countrySpinner = findViewById(R.id.countrySpinner);
        populationSizeTextView = findViewById(R.id.populationSizeTextView);
        areaTextView = findViewById(R.id.areaTextView);

        // חיבור מאזינים
        continentSpinner.setOnItemSelectedListener(this);
        countrySpinner.setOnItemSelectedListener(this);
        cityListView.setOnItemClickListener(this);

        // איתחול יבשות
        ArrayAdapter<String> continentAdapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item,
                continents);
        continentSpinner.setAdapter(continentAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        populationSizeTextView.setText("");
        areaTextView.setText("");
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item,
                new String[]{});
        cityListView.setAdapter(cityAdapter);

        if(parent == continentSpinner) { // בחרו יבשת
            selectedCountryIndex = 0;
            selectedContinentIndex = position;
            ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(
                    this, R.layout.support_simple_spinner_dropdown_item,
                    countries[position]);
            countrySpinner.setAdapter(countryAdapter);
        } else { // בחרו מדינה
            selectedCountryIndex = position;
            String[][] cityNames;

            switch(selectedContinentIndex) {
                case ASIA:
                    cityNames = asiaCityNames;
                    break;
                case EUROPE:
                    cityNames = europeCityNames;
                    break;
                case AFRICA:
                    cityNames = africaCityNames;
                    break;
                case AMERICA:
                default:
                    cityNames = americaCityNames;
                    break;
            }

            ArrayAdapter<String> cityAdpater = new ArrayAdapter<String>(
                    this, R.layout.support_simple_spinner_dropdown_item,
                    cityNames[selectedCountryIndex]);
            cityListView.setAdapter(cityAdpater);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[][] cityDetailsMatrix;

        switch(selectedContinentIndex) {
            case ASIA:
                cityDetailsMatrix = asiaCityDetails;
                break;
            case EUROPE:
                cityDetailsMatrix = europeCityDetails;
                break;
            case AFRICA:
                cityDetailsMatrix = africaCityDetails;
                break;
            case AMERICA:
            default:
                cityDetailsMatrix = americaCityDetails;
                break;
        }

        String cityDetailsCombined
                = cityDetailsMatrix[selectedCountryIndex][position];
        String[] cityDetailsSeparate = cityDetailsCombined.split(" ");
        populationSizeTextView.setText(cityDetailsSeparate[0]);
        areaTextView.setText(cityDetailsSeparate[1]);
    }
}
