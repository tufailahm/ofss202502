define([
  'knockout',
  'ojs/ojrestdataprovider',
  'ojs/ojarraydataprovider',
  'ojs/ojinputtext',
  'ojs/ojselectsingle',
  'ojs/ojformlayout',
  'ojs/ojbutton',
  'ojs/ojtable',

],
  function (ko, RESTDataProvider) {
    this.url = "http://localhost:9090/visitors";

    function ListVisitorsViewModel(params) {

      var self = this;
      self.router = params && params.parentRouter;

      this.dataprovider = ko.observable(null);

      this.loadVisitor = () => {

        url = "http://localhost:9090/visitors";

        console.log("Load visitor called2");
        this.dataprovider = new RESTDataProvider.RESTDataProvider({
          keyAttributes: this.keyAttributes,
          url: url,
          transforms: {
            fetchFirst: {
              request: async (options) => {
                const url = new URL(options.url);
                return new Request(url.href);
              },
              response: async ({ body }) => {
                console.log("BODY :" + body);
                return { data: body };
              },
            },
          },
        });
        console.log("Load visitor called done");


      }

      goToSavePage = () => {
        alert("Navigating to Add Visitor");
        self.router.go({ path : "addVisitors"});
      }
      this.loadVisitor();
    }
    return ListVisitorsViewModel;
  }
);