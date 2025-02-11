package proxy.protected_docs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Map<String, Set<String>> accessMap;

    private AccessControlService() {
        accessMap = new HashMap<>();
    }

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String documentId, String username) {
        // create a new set if the documentId is not in the map so we can add new users with access
        if (!accessMap.containsKey(documentId)) {
            accessMap.put(documentId, new HashSet<>());
        }

        accessMap.get(documentId).add(username);
    }

    public boolean isAllowed(String documentId, String username) {
        return accessMap.getOrDefault(documentId, new HashSet<>()).contains(username);
    }
}