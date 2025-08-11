function fetchData(callback) {
  console.log("1. Fetching data...");

  setTimeout(() => {
    const data = { id: 1, name: "Tufail" };
    callback(data); // data ready
  }, 3000);

 console.log("2. Data Processed...");
}
fetchData(result => {
  console.log("3. Data received:", result);
});