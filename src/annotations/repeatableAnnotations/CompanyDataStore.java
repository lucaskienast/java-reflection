package annotations.repeatableAnnotations;

import annotations.repeatableAnnotations.annotations.Annotations;

@Annotations.Permissions(role = Role.CLERK, allowed = OperationType.READ)
@Annotations.Permissions(role = Role.MANAGER, allowed = {OperationType.READ, OperationType.WRITE})
@Annotations.Permissions(role = Role.SUPPORT_ENGINEER, allowed = {OperationType.READ, OperationType.WRITE, OperationType.DELETE})
public class CompanyDataStore {

    private User user;

    public void CompanyDataStore(User user) {
        this.user = user;
    }

    @Annotations.MethodOperations(OperationType.READ)
    public AccountRecord[] readAccounts(String [] accountIds) throws Throwable {
        PermissionsChecker.checkPermissions(this, "readAccounts");
        // ...
        return null;
    }

    @Annotations.MethodOperations({OperationType.READ, OperationType.WRITE})
    public void updateAccount(String accountId, AccountRecord record) throws Throwable {
        PermissionsChecker.checkPermissions(this, "updateAccount");
        // ...
    }

    @Annotations.MethodOperations(OperationType.READ)
    public Summary readAccountSummary(Role callerRole, String accountId) throws Throwable {
        PermissionsChecker.checkPermissions(this, "readAccountSummary");
        // ...
        return null;
    }

    @Annotations.MethodOperations(OperationType.DELETE)
    public void deleteAccount(String accountId) throws Throwable {
        PermissionsChecker.checkPermissions(this, "deleteAccount");
        // ...
    }

}
