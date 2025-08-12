define(['ojs/ojmodel'], function (oj) {
    var VisitorModel = oj.Model.extend({
        idAttribute: 'visitorId',
        urlRoot: 'http://localhost:9090/visitors'
    });
    return VisitorModel;
});
