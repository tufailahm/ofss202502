function fetchData(callback) {
  console.log("1. Fetching data...");
  setTimeout(() => {
    const data = { id: 1, name: "Tufail" };
    callback(data); // data ready
  }, 3000);
}

fetchData(result => {
  console.log("5. Data received:", result);
});

console.log("2. Start");

setTimeout(() => {
  console.log("4. Async Callback");
}, 2000);

console.log("3. End");