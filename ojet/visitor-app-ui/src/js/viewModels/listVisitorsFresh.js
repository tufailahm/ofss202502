define([
    'knockout',
    'ojs/ojtable',
    'ojs/ojmodel',
    'models/VisitorCollection',
    'ojs/ojcollectiondataprovider',
    'ojs/ojbutton',
    'ojs/ojformlayout',
    'ojs/ojinputtext',
    'ojs/ojdialog'
], function (ko, ojtable, ojmodel, VisitorCollection, CollectionDataProvider) {

    function VisitorsFreshViewModel() {
        var self = this;

        // Collection
        self.collection = new VisitorCollection();
        self.dataProvider = ko.observable();
        // Fetch data
        self.collection.fetch({
            success: function () {
                self.dataProvider(new CollectionDataProvider(self.collection));
                console.log("Data loaded");
                self.collection.each(function (model) {
                    console.log(model.toJSON());
                });
            },
            error: function (jqXHR, textStatus) {
                console.error("Fetch error:", textStatus);
            }
        });


        //save code
        self.visitorId = ko.observable();
        self.visitorName = ko.observable();
        self.purpose = ko.observable();
        self.mobileNumber = ko.observable();

        // Add new visitor
        self.addVisitor = function () {
            var newVisitor = {
                visitorId: self.visitorId(),
                visitorName: self.visitorName(),
                purpose: self.purpose(),
                mobileNumber: self.mobileNumber()
            };
            self.collection.create(newVisitor, {
                wait: true,
                success: function () {
                    alert(self.visitorName() + " registered successfully")
                    document.getElementById("addDialog").close();
                }
            })
        }

        // Edit visitor
        self.editVisitor = function (row) {
            var model = self.collection.get(row.visitorId);
            if (model) {
                model.save({
                    visitorName: self.visitorName(),
                    purpose: self.purpose(),
                    mobileNumber: self.mobileNumber()
                }, { wait: true });
                document.getElementById("editDialog").close();
            }
        };

        // Delete visitor
        self.deleteVisitor = (row) => {
            var model = self.collection.get(row.visitorId);
            if (model) {
                model.destroy({ wait: true });
            }
        };
    }
    return new VisitorsFreshViewModel();
});


