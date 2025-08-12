define([
  'knockout',
  'ojs/ojarraydataprovider',
  'ojs/ojasyncvalidator-length',
  'ojs/ojvalidator-regexp',
  'ojs/ojinputtext',
  'ojs/ojselectsingle',
  'ojs/ojformlayout',
  'ojs/ojvalidationgroup',
  'ojs/ojbutton'
],
  function (ko, ArrayDataProvider, AsyncLengthValidator, RegExpValidator) {

    function AddVisitorsViewModel(params) {

      this.visitorId = ko.observable("");
      this.visitorName = ko.observable("");
      this.purpose = ko.observable("");
      this.mobileNumber = ko.observable("");

      var self = this;
      // Router passed from main
      self.router = params && params.parentRouter;



      this.isFormInvalid = ko.observable(true);
      this.saveButtonDisabled = ko.observable(true);
      this.mobileValidator = new RegExpValidator({
        pattern: "^[0-9]{10}$",
        hint: "Enter exactly 10 digits",
        messageDetail: "Invalid mobile number format"
      });

      this.inputVisitorNamevalidators = ko.observableArray([
        new AsyncLengthValidator({
          min: 4, max: 12
        })
      ]);


      // Called when oj-validation-group fires validChanged
      this.groupValidChanged = (event) => {
        // 'valid' means all fields are good, 'invalidHidden' or 'invalidShown' means not valid
        console.log(" Before Valid called " + event.detail.value + " Form status :" + this.isFormInvalid)
        this.isFormInvalid(event.detail.value !== 'valid');
        console.log("After Valid called " + event.detail.value + " Form status :" + this.isFormInvalid)

      };


      this.saveVisitor = async () => {
        let group = document.getElementById('visitorForm');
        if (group.valid !== 'valid') {
          group.showMessages();
          group.focusOn('@firstInvalidShown');
          console.warn("Form has errors. Cannot save.");
          return;
        }
        console.log("Visitor Saved:", {
          visitorId: this.visitorId(),
          visitorName: this.visitorName(),
          mobileNumber: this.mobileNumber(),
          purpose: this.purpose()
        });


        const visitior = {
          visitorId: this.visitorId(),
          visitorName: this.visitorName(),
          mobileNumber: this.mobileNumber(),
          purpose: this.purpose(),
        };
        url = "http://localhost:9090/visitors"
        const request = new Request(url, {
          headers: new Headers({
            "Content-type": "application/json; charset=UTF-8",
          }),
          body: JSON.stringify(visitior),
          method: "POST",
        });
        const response = await fetch(request);
        console.log("Visitor saved successfully");
        alert("Visitor Saved successfully")
        if (self.router) {
          self.router.go({ path: 'listVisitors' }); // Navigate after saving
        }
        else {
          console.log("Self router is not defined")
        }

      }





    }

    /*
          this.saveVisitor = () => {
            console.log("Visitor Saved:", {
              visitorId: this.visitorId(),
              visitornName: this.visitorName(),
              purpose: this.purpose(),
              mobileNumber: this.mobileNumber()
            });
          };
    */
    this.updateVisitor = () => {
      console.log("Visitor Updated:", this.visitorId());
    };

    this.deleteVisitor = () => {
      console.log("Visitor Deleted:", this.visitorId());
    };

    this.searchVisitor = () => {
      console.log("Search Visitor:", this.visitorId());
    };


    return AddVisitorsViewModel;
  });
