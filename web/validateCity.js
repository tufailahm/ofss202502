function updateToCity() {
    const fromCity = document.getElementById('fromCity');
    const toCity = document.getElementById('toCity');
    const selectedFromCity = fromCity.value;

    const currentlySelectedToCity = toCity.value;

    toCity.innerHTML = '<option value="">Select City</option>';

    const cities = ['New York', 'Los Angeles', 'Chicago', 'Houston', 'Phoenix'];
    cities.forEach(city => {
        if (city !== selectedFromCity) {
            const option = document.createElement('option');
            option.value = city;
            option.text = city;
            toCity.appendChild(option);
        }
    });

    toCity.value = currentlySelectedToCity !== selectedFromCity ? currentlySelectedToCity : '';
}

document.getElementById('toCity').onchange = function() {
    const fromCity = document.getElementById('fromCity');
    const toCity = document.getElementById('toCity');
    const selectedToCity = toCity.value;

    const currentlySelectedFromCity = fromCity.value;

    fromCity.innerHTML = '<option value="">Select City</option>';

    const cities = ['New York', 'Los Angeles', 'Chicago', 'Houston', 'Phoenix'];
    cities.forEach(city => {
        if (city !== selectedToCity) {
            const option = document.createElement('option');
            option.value = city;
            option.text = city;
            fromCity.appendChild(option);
        }
    });

    fromCity.value = currentlySelectedFromCity !== selectedToCity ? currentlySelectedFromCity : '';
};
