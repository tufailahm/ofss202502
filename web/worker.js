onmessage = function(e) {
  console.log("Worker received:", e.data);
  let result = e.data * 2;
  postMessage(result); // send back to main thread
};