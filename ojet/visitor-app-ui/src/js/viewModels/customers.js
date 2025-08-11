define([
  'knockout',
  'ojs/ojarraydataprovider',
  'ojs/ojinputtext',
  'ojs/ojselectsingle',
  'ojs/ojformlayout',
  'ojs/ojbutton'
],
  function (ko, ArrayDataProvider) {
    function CustomerViewModel() {
      this.username = ko.observable("Ahmed");
      this.selectVal = "O";
      this.customerType = [
        { value: 'O', label: 'Permanent' },
        { value: 'C', label: 'Contractual' },
        { value: 'F', label: 'Freelance' },
        { value: 'V', label: 'Vendor' }
      ];
      this.customerTypeDataProvider = new ArrayDataProvider(this.customerType, {
        keyAttributes: 'value'
      })

      this.saveVisitor1 = () => {
        console.log("Save visitor1 called");
        this.username("Meenal")
      }
      this.saveVisitor2 = this.saveVisitor2.bind(this);
    }


    CustomerViewModel.prototype.saveVisitor2 = function () {
      console.log("Save visitor2 called");
      this.username("Rohan");
    }

    return CustomerViewModel;
  }
);